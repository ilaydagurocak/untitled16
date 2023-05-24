package Piece;

import java.awt.Color;
import java.awt.Graphics;

import Game.FieldSquare;
import Game.Game;

public class Piece {



    public static final int RECT_WIDTH = 30;
    public static final int RECT_HEIGHT = 30;


    private int x;
    private int y;

    private PieceShape shape;

    public Piece(int x, int y, PieceShape shape) {
        this.setX(x);
        this.setY(y);

        this.setShape(shape);
    }


        public int getWidth() {
            return this.shape.getWidth();
        }

        public int getHeight() {
            return this.shape.getHeight();
        }


        public void render(Graphics g) {
            PieceShape shape = this.getShape();
            int shapeHeight = shape.getHeight();
            int shapeWidth = shape.getWidth();

            for (int row = 0; row < shapeHeight; row++) {
                for (int col = 0; col < shapeWidth; col++) {
                    if (shape.isPieceBrick(row, col)) {
                        int rectX = (this.x + col) * Piece.RECT_WIDTH;
                        int rectY = (this.y + row) * Piece.RECT_HEIGHT;

                        g.setColor(shape.getColor());
                        g.fillRect(rectX, rectY, Piece.RECT_WIDTH, Piece.RECT_HEIGHT);
                        g.setColor(Color.WHITE);
                        g.drawRect(rectX, rectY, Piece.RECT_WIDTH, Piece.RECT_HEIGHT);
                    }
                }
            }
        }

        public void tick() {
            this.moveDown();
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public void rotate() {
            this.shape.rotate();
        }

        public void undoRotate() {
            this.shape.undoRotate();
        }

        public void movePieceToStartingPoing() {
            this.setX(Game.STARTING_PIECE_X);
            this.setY(Game.STARTING_PIECE_Y);
        }
        public void movePieceToStartingPoint() {
            this.setX(Game.STARTING_PIECE_X);
            this.setY(Game.STARTING_PIECE_Y);
        }

        public void moveLeft() {
            this.x--;
        }

        public void moveRight() {
            this.x++;
        }

        public void moveDown() {
            this.y++;
        }

        public void moveUp() {
            this.y--;
        }

        private void setShape(PieceShape shape) {
            this.shape = shape;
        }

        public PieceShape getShape() {
            return this.shape;
        }

    public void render(Graphics graphics, int renderX, int renderY) {
        PieceShape shape = this.getShape();
        int shapeHeight = shape.getHeight();
        int shapeWidth = shape.getWidth();

        for (int row = 0; row < shapeHeight; row++) {
            for (int col = 0; col < shapeWidth; col++) {
                if (shape.isPieceBrick(row, col)) {
                    int rectX = renderX + col * Piece.RECT_WIDTH;
                    int rectY = renderY + row * Piece.RECT_HEIGHT;

                    graphics.setColor(shape.getColor());
                    graphics.fillRect(rectX, rectY, Piece.RECT_WIDTH, Piece.RECT_HEIGHT);
                    graphics.setColor(Color.WHITE);
                    graphics.drawRect(rectX, rectY, Piece.RECT_WIDTH, Piece.RECT_HEIGHT);
                }
            }
        }
    }

}
