package solid


/** Dependency Inversion is the strategy of depending upon interfaces or
 abstract functions and classes rather than upon concrete functions and classes.
this is hard coupling **/

class KeyBoard {
    fun perform() {}
}

class Mouse {
    fun perform() {}
}


class Computer constructor(val keyBoard: KeyBoard, val mouse: Mouse) {
    fun input() {
        keyBoard.perform()
        mouse.perform()
    }
}

/*************************/
interface IKeyboard{
     fun perform()
}

interface IMouse{
    fun perform()
}


class KeyBoardImpl(): IKeyboard{
    override fun perform() {
        TODO("Not yet implemented")
    }

}

class MouseImpl(): IMouse{
    override fun perform() {
        TODO("Not yet implemented")
    }

}


class Computer2 constructor(val keyBoard: IKeyboard, val mouse: IMouse) {
    fun input() {
        keyBoard.perform()
        mouse.perform()
    }
}