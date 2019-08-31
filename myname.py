import turtle

# global constants for window dimensions
WINDOW_WIDTH = 560
WINDOW_HEIGHT = 400

def init():
    """
    Initialize for drawing.  (-200, -200) is in the lower left and
    (200, 200) is in the upper right.
    :pre: pos (0,0), heading (east), up
    :post: pos (0,0), heading (east), up
    :return: None
    """
    turtle.setworldcoordinates(-WINDOW_WIDTH/2, -WINDOW_WIDTH/2,
        WINDOW_WIDTH/2, WINDOW_HEIGHT/2)
    turtle.up()
    turtle.setheading(0)
    turtle.hideturtle()
    turtle.title('MyName')
    turtle.speed(0)

def drawLetterA(dist):
    """
    Draw the Letter A.
    :pre: (relative) pos (0,0), heading (east), up
    :post: (relative) pos (0,0), heading (east), up
    :return: None
    """
    turtle.color('blue')
    if(dist<0):
        dist *= -1
        turtle.left(180)
        turtle.forward(dist)
    else:
        turtle.forward(dist)
        turtle.left(180)
    turtle.down()
    turtle.right(110.56)
    turtle.forward(85.44)
    turtle.right(139)
    turtle.forward(85.44)
    turtle.up()
    turtle.right(180)
    turtle.forward(42.72)
    turtle.down()
    turtle.left(69.44)
    turtle.forward(30)
    turtle.up()

def drawLetterR(dist):
    """
    Draw the Letter R.
    :pre: (relative) pos (0,0), heading (east), up
    :post: (relative) pos (0,0), heading (east), up
    :return: None
    """
    turtle.color('blue')
    if(dist<0):
        dist *= -1
        turtle.left(180)
        turtle.forward(dist)
    else:
        turtle.forward(dist)
        turtle.left(180)
    turtle.down()
    turtle.right(90)
    turtle.forward(80)
    turtle.right(90)
    turtle.forward(40)
    turtle.right(90)
    turtle.forward(40)
    turtle.right(90)
    turtle.forward(40)
    turtle.left(135)
    turtle.forward(54)
    turtle.up()

def drawLetterJ(dist):
    """
    Draw the Letter J.
    :pre: (relative) pos (0,0), heading (east), up
    :post: (relative) pos (0,0), heading (east), up
    :return: None
    """
    turtle.color('blue')
    if(dist<0):
        dist *= -1
        turtle.left(180)
        turtle.forward(dist)
    else:
        turtle.forward(dist)
        turtle.left(180)
    turtle.right(90)
    turtle.forward(30)
    turtle.down()
    turtle.right(180)
    turtle.forward(30)
    turtle.left(90)
    turtle.forward(30)
    turtle.left(90)
    turtle.forward(80)
    turtle.up()
    turtle.left(90)
    turtle.forward(30)
    turtle.down()
    turtle.left(180)
    turtle.forward(60)
    turtle.up()

def drawLetterJ(dist):
    """
    Draw the Letter J.
    :pre: (relative) pos (0,0), heading (east), up
    :post: (relative) pos (0,0), heading (east), up
    :return: None
    """
    turtle.color('blue')
    if(dist<0):
        dist *= -1
        turtle.left(180)
        turtle.forward(dist)
    else:
        turtle.forward(dist)
        turtle.left(180)
    turtle.right(90)
    turtle.forward(30)
    turtle.down()
    turtle.right(180)
    turtle.forward(30)
    turtle.left(90)
    turtle.forward(30)
    turtle.left(90)
    turtle.forward(80)
    turtle.up()
    turtle.left(90)
    turtle.forward(30)
    turtle.down()
    turtle.left(180)
    turtle.forward(60)
    turtle.up()

def drawLetterU(dist):
    """
    Draw the Letter U.
    :pre: (relative) pos (0,0), heading (east), up
    :post: (relative) pos (0,0), heading (east), up
    :return: None
    """
    turtle.color('blue')
    if(dist<0):
        dist *= -1
        turtle.left(180)
        turtle.forward(dist)
    else:
        turtle.forward(dist)
        turtle.left(180)
    turtle.right(90)
    turtle.forward(80)
    turtle.down()
    turtle.right(180)
    turtle.forward(80)
    turtle.left(90)
    turtle.forward(60)
    turtle.left(90)
    turtle.forward(80)
    turtle.up()

def drawLetterN(dist):
    """
    Draw the Letter N.
    :pre: (relative) pos (0,0), heading (east), up
    :post: (relative) pos (0,0), heading (east), up
    :return: None
    """
    turtle.color('blue')
    if(dist<0):
        dist *= -1
        turtle.left(180)
        turtle.forward(dist)
    else:
        turtle.forward(dist)
        turtle.left(180)
    turtle.down()
    turtle.right(90)
    turtle.forward(80)
    turtle.right(143.13)
    turtle.forward(100)
    turtle.left(143.13)
    turtle.forward(80)
    turtle.up()

def drawLetterK(dist):
    """
    Draw the Letter K.
    :pre: (relative) pos (0,0), heading (east), up
    :post: (relative) pos (0,0), heading (east), up
    :return: None
    """
    turtle.color('blue')
    if(dist<0):
        dist *= -1
        turtle.left(180)
        turtle.forward(dist)
    else:
        turtle.forward(dist)
        turtle.left(180)
    turtle.down()
    turtle.right(90)
    turtle.forward(80)
    turtle.up()
    turtle.left(180)
    turtle.forward(40)
    turtle.down()
    turtle.left(50)
    turtle.forward(60)
    turtle.up()
    turtle.left(180)
    turtle.forward(60)
    turtle.down()
    turtle.right(100)
    turtle.forward(60)
    turtle.up()

def drawName():
    """
    Draw a single snake.
    :pre: (relative) pos (0,0), heading (east), up
    :post: (relative) pos (0,0), heading (east), up
    :return: None
    """
    drawLetterA(-270)
    resetTurtle()
    drawLetterR(-190)
    resetTurtle()
    drawLetterJ(-110)
    resetTurtle()
    drawLetterU(-30)
    resetTurtle()
    drawLetterN(50)
    resetTurtle()
    drawLetterR(130)
    resetTurtle()
    drawLetterK(210)

def resetTurtle():
    turtle.setx(0)
    turtle.sety(0)
    turtle.setheading(0)

def main():
    """
    The main function.
    :pre: pos (0,0), heading (east), up
    :post: pos (0,0), heading (east), up
    :return: None
    """
    init()
    drawName()
    turtle.left(180)

    turtle.mainloop()

if __name__ == '__main__':
    main()