
let all_songs = [
  {
    name: "senjitaley",
    path: "songs/Senjitaley.mp3",
    img: "images/Senjitaley.jpg",
    artist: "SivaKarthikeyen,Keerthi",
    favorite:false
  },
  {
    name: "arabic kuthu",
    path: "songs/ArabicKuthu.mp3",
    img: "images/arabickuthu.jpg",
    artist: "Vijay, Pooja",
    favorite:false
  },
  {
    name: "Thaai-kelavi",
    path: "songs/Thaai-Kelavi.mp3",
    img: "images/Thaai-kelavi.jpg",
    artist: "Dhanush, Nithya Menon",
    favorite:false
  },
  {
    name: "enna na seiven",
    path: "songs/Enna-Naan-Seiven.mp3",
    img: "images/meyadhamaan.jpg",
    artist: "Vaibhav, Priya",
    favorite:false
  },
];
playerClipboard();
function playerClipboard() {
  const headerDiv = document.createElement("div");
  headerDiv.classList.add("header");

  const heading = document.createElement("h5");
  heading.classList.add("text");
  heading.innerText = "MY MUSIC PLAYER";

  const barButton = document.createElement("button");
  barButton.classList.add("bar");
  const barIcon = document.createElement("i");
  barIcon.classList.add("bx", "bx-menu");
  barButton.appendChild(barIcon);

  headerDiv.append(heading, barButton);

  const playerImage = document.createElement("img");
  playerImage.classList.add("player-image");

  const titleParagraph = document.createElement("p");
  titleParagraph.classList.add("title");
  titleParagraph.textContent = "title";

  const artistParagraph = document.createElement("p");
  artistParagraph.classList.add("artist");
  artistParagraph.textContent = "artist";

  const rangeInput = document.createElement("input");
  rangeInput.classList.add("slider");
  rangeInput.type = "range";
  rangeInput.min = "0";
  rangeInput.max = "100";
  rangeInput.value = "0";
  rangeInput.onclick = function () {
    changeDuration();
  };

  const btn1 = document.createElement("button");
  btn1.classList.add("btn1");
  const btn1Icon = document.createElement("i");
  btn1Icon.classList.add("bx", "bxs-heart");
  btn1.appendChild(btn1Icon);

  btn1.addEventListener("click", function () {
 btn1.classList.toggle("active");
  });

  const btn2 = document.createElement("button");
  btn2.classList.add("btn2");
  const btn2Icon = document.createElement("i");
  btn2Icon.classList.add("bx", "bx-caret-left");
  btn2.appendChild(btn2Icon);

  btn2.onclick = function () {
    previousSong();
  };

  const btn3 = document.createElement("button");
  btn3.classList.add("btn3");
  const btn3Icon = document.createElement("i");
  btn3Icon.classList.add("bx", "bx-play");
  btn3.appendChild(btn3Icon);

  btn3.onclick = function () {
    playSong();
  };

  const btn4 = document.createElement("button");
  btn4.classList.add("btn4");
  const btn4Icon = document.createElement("i");
  btn4Icon.classList.add("bx", "bx-caret-right");
  btn4.appendChild(btn4Icon);
  btn4.onclick = function () {
    nextSong();
  };

  const mainDiv = document.getElementById("main");

  mainDiv.append(
    headerDiv,
    playerImage,
    titleParagraph,
    artistParagraph,
    rangeInput,
    btn1,
    btn2,
    btn3,
    btn4
  );

}

let timer;

let index = 0;
let playing_song = false;
let track = document.createElement("audio");

loadTrack(index);
function loadTrack(index) {
  clearInterval(timer);
  resetSlider();

  track.src = all_songs[index].path;
  document.querySelector(".title").innerText = all_songs[index].name;
  document.querySelector(".player-image").src = all_songs[index].img;
  document.querySelector(".artist").innerText = all_songs[index].artist;

  timer = setInterval(updateSlider, 1000);
}

function resetSlider() {
  document.querySelector(".slider").value = 0;
}

function playSong() {
  if (!playing_song) {
    track.play();
    document.querySelector(".btn3 i").classList.remove("bx-play");
    document.querySelector(".btn3 i").classList.add("bx-pause");
    playing_song = true;
    startMovingContainer();
  } else {
    track.pause();
    document.querySelector(".btn3 i").classList.remove("bx-pause");
    document.querySelector(".btn3 i").classList.add("bx-play");
    playing_song = false;
    stopMovingContainer();
  }
}

function nextSong() {
  index = (index + 1) % all_songs.length;
  loadTrack(index);
  playSong();
}

function previousSong() {
  index = (index - 1 + all_songs.length) % all_songs.length;
  loadTrack(index);
  playSong();
}

function updateSlider() {
  const duration = track.duration;
  const currentTime = track.currentTime;
  const position = (currentTime / duration) * 100;
  document.querySelector(".slider").value = position;
}

function changeDuration() {
  const sliderPosition =
    track.duration * (document.querySelector(".slider").value / 100);
  track.currentTime = sliderPosition;
}

let isMovingUp = false;
let moveInterval;

function moveMainContainerUp() {
  const mainDiv = document.getElementById("main");
  mainDiv.style.transform = "translateY(-10px)";
}

function moveMainContainerDown() {
  const mainDiv = document.getElementById("main");
  mainDiv.style.transform = "translateY(10px)";
}

function startMovingContainer() {
  clearInterval(moveInterval);

  moveInterval = setInterval(function () {
    if (!isMovingUp) {
      moveMainContainerUp();
    } else {
      moveMainContainerDown();
    }

    isMovingUp = !isMovingUp;
  }, 1000);
}

function stopMovingContainer() {
  clearInterval(moveInterval);

  moveMainContainerDown();
}



