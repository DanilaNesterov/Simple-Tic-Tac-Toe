package tictactoe


var xWins = false
var oWins = false
var field = mutableListOf(mutableListOf('_', '_', '_'), mutableListOf('_', '_', '_'), mutableListOf('_', '_', '_'))

fun main() {
    game()
}

fun showField(){
    println("---------\n"+
            "| ${field[0][0]} ${field[0][1]} ${field[0][2]} |\n"+
            "| ${field[1][0]} ${field[1][1]} ${field[1][2]} |\n" +
            "| ${field[2][0]} ${field[2][1]} ${field[2][2]} |\n" +
            "---------")
}
fun getResult(){
    when {
        xWins && !oWins ->  println("X wins")
        !xWins && oWins ->  println("O wins")
        !xWins && !oWins -> println("Draw")
    }

}
fun checkWinner(){
    if (field[0][0] == 'X' && field[0][1] == 'X' && field[0][2] == 'X' ||
        field[1][0] == 'X' && field[1][1] == 'X' && field[1][2] == 'X' ||
        field[2][0] == 'X' && field[2][1] == 'X' && field[2][2] == 'X' ||
        field[0][0] == 'X' && field[1][0] == 'X' && field[2][0] == 'X' ||
        field[0][1] == 'X' && field[1][1] == 'X' && field[2][2] == 'X' ||
        field[0][2] == 'X' && field[1][2] == 'X' && field[2][2] == 'X' ||
        field[0][0] == 'X' && field[1][1] == 'X' && field[2][2] == 'X' ||
        field[0][2] == 'X' && field[1][1] == 'X' && field[2][0] == 'X') xWins = true

    if (field[0][0] == 'O' && field[0][1] == 'O' && field[0][2] == 'O' ||
        field[1][0] == 'O' && field[1][1] == 'O' && field[1][2] == 'O' ||
        field[2][0] == 'O' && field[2][1] == 'O' && field[2][2] == 'O' ||
        field[0][0] == 'O' && field[1][0] == 'O' && field[2][0] == 'O' ||
        field[0][1] == 'O' && field[1][1] == 'O' && field[2][2] == 'O' ||
        field[0][2] == 'O' && field[1][2] == 'O' && field[2][2] == 'O' ||
        field[0][0] == 'O' && field[1][1] == 'O' && field[2][2] == 'O' ||
        field[0][2] == 'O' && field[1][1] == 'O' && field[2][0] == 'O' ) oWins = true

}

fun makeMoveX() {
    val coord = readln().split(" ")


    if (coord[0].toInt() !in 1..3 || coord[1].toInt() !in 1..3) {
        println("Coordinates should be from 1 to 3!")
        return makeMoveX()
    }
    if (field[coord[0].toInt() - 1][coord[1].toInt() - 1] != '_'){
        println("This cell is occupied! Choose another one!")
        return makeMoveX()
    }
    if (coord[0].toIntOrNull() == null || coord[1].toIntOrNull() == null){
        println("You should enter numbers!")
        return makeMoveX()
    }

    field[coord[0].toInt() - 1][coord[1].toInt() - 1] = 'X'
    checkWinner()

}

fun makeMoveO() {
    val coord = readln().split(" ")


    if (coord[0].toInt() !in 1..3 || coord[1].toInt() !in 1..3) {
        println("Coordinates should be from 1 to 3!")
        return makeMoveO()
    }
    if (field[coord[0].toInt() - 1][coord[1].toInt() - 1] != '_'){
        println("This cell is occupied! Choose another one!")
        return makeMoveO()
    }
    if (coord[0].toIntOrNull() == null || coord[1].toIntOrNull() == null){
        println("You should enter numbers!")
        return makeMoveO()
    }

    field[coord[0].toInt() - 1][coord[1].toInt() - 1] = 'O'
    checkWinner()
}

fun game(){
    showField()
    var count = 0
    while (true){
        count++
        makeMoveX()
        if (xWins) {
            showField()
            break
        } else {
            showField()
        }
        if (count == 9) break
        makeMoveO()
        if (oWins) {
            showField()
            break
        } else {
            showField()
        }
        count++

    }
    getResult()
}