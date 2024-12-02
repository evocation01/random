const canvas = document.getElementById("tetris");
const context = canvas.getContext("2d");

// Set canvas size to match the game area
canvas.width = 12 * 20;  // 12 columns, each of size 20px
canvas.height = 20 * 20; // 20 rows, each of size 20px

let score = 0;
let arena = createMatrix(12, 20); // 12 columns, 20 rows

// Tetromino shapes (blocks)
const tetrominoes = [
    [[1, 1, 1], [0, 1, 0]], // T-shape
    [[1, 1], [1, 1]], // Square
    [[1, 1, 0], [0, 1, 1]], // S-shape
    [[0, 1, 1], [1, 1, 0]], // Z-shape
    [[1, 1, 1, 1]], // Line
    [[1, 0, 0], [1, 1, 1]], // L-shape
    [[0, 0, 1], [1, 1, 1]] // J-shape
];

let currentPiece = generatePiece();
let gameOver = false;

// Create the game area (empty matrix)
function createMatrix(w, h) {
    const matrix = [];
    while (h--) {
        matrix.push(new Array(w).fill(0));
    }
    return matrix;
}

// Generate a random piece
function generatePiece() {
    const id = Math.floor(Math.random() * tetrominoes.length);
    const matrix = tetrominoes[id];
    return {
        matrix: matrix,
        x: Math.floor(arena[0].length / 2) - Math.floor(matrix[0].length / 2),
        y: 0
    };
}

// Rotate a piece
function rotate(matrix) {
    return matrix[0].map((_, index) => matrix.map(row => row[index])).reverse();
}

// Check if the piece collides with existing blocks in the arena
function collide(arena, piece) {
    for (let y = 0; y < piece.matrix.length; y++) {
        for (let x = 0; x < piece.matrix[y].length; x++) {
            if (piece.matrix[y][x] !== 0) {
                if (arena[y + piece.y] && arena[y + piece.y][x + piece.x]) {
                    return true;
                }
            }
        }
    }
    return false;
}

// Merge the piece into the arena when it lands
function merge(arena, piece) {
    piece.matrix.forEach((row, y) => {
        row.forEach((value, x) => {
            if (value !== 0) {
                arena[y + piece.y][x + piece.x] = value;
            }
        });
    });
}

// Clear full lines
function clearLines() {
    outer: for (let y = arena.length - 1; y >= 0; y--) {
        if (arena[y].every(cell => cell !== 0)) {
            arena.splice(y, 1);
            arena.unshift(new Array(arena[0].length).fill(0)); // Add new empty row
            score += 100; // Increase score
        }
    }
}

// Draw the matrix (arena or piece)
function drawMatrix(matrix, offset) {
    matrix.forEach((row, y) => {
        row.forEach((value, x) => {
            if (value !== 0) {
                context.fillStyle = "red";
                context.fillRect((x + offset.x) * 20, (y + offset.y) * 20, 20, 20);
            }
        });
    });
}

// Update the game state and redraw
function update() {
    if (gameOver) {
        alert("Game Over");
        return;
    }

    clearLines();
    drawMatrix(arena, { x: 0, y: 0 });

    if (currentPiece.y + currentPiece.matrix.length >= arena.length || collide(arena, currentPiece)) {
        merge(arena, currentPiece);
        currentPiece = generatePiece();
        if (collide(arena, currentPiece)) {
            gameOver = true;  // End game if new piece collides
        }
    } else {
        currentPiece.y++;
    }

    drawMatrix(currentPiece.matrix, { x: currentPiece.x, y: currentPiece.y });
    document.getElementById("score").textContent = "Score: " + score;
}

// Handle keyboard input
document.addEventListener("keydown", (e) => {
    if (gameOver) return;

    if (e.key === "ArrowLeft") {
        currentPiece.x--;
        if (collide(arena, currentPiece)) {
            currentPiece.x++;
        }
    } else if (e.key === "ArrowRight") {
        currentPiece.x++;
        if (collide(arena, currentPiece)) {
            currentPiece.x--;
        }
    } else if (e.key === "ArrowDown") {
        currentPiece.y++;
        if (collide(arena, currentPiece)) {
            currentPiece.y--;
        }
    } else if (e.key === "ArrowUp") {
        const rotated = rotate(currentPiece.matrix);
        const backup = currentPiece.matrix;
        currentPiece.matrix = rotated;
        if (collide(arena, currentPiece)) {
            currentPiece.matrix = backup;
        }
    } else if (e.key === " ") { // Spacebar: instant drop
        while (!collide(arena, currentPiece)) {
            currentPiece.y++;
        }
        currentPiece.y--;
    }
});

// Game loop (repeat every 500ms)
function loop() {
    update();
    if (!gameOver) {
        setTimeout(loop, 500); // Slow down the game loop
    }
}

loop();
