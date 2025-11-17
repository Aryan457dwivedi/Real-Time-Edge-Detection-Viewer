const img = document.getElementById('frame');
const fpsSpan = document.getElementById('fps');
let last = performance.now();
function update() {
  const now = performance.now();
  const dt = now - last;
  last = now;
  const fps = Math.round(1000 / dt);
  if (fpsSpan) fpsSpan.innerText = fps.toString();
  requestAnimationFrame(update);
}
fetch('sample_frame.txt').then(r => r.text()).then(b64 => {
  if (img) img.src = 'data:image/png;base64,' + b64.trim();
  requestAnimationFrame(update);
});
