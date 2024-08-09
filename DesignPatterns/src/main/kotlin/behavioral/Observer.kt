interface StockObserver {
    fun updated() {}
}

class StockObservable {
    private val observerList = mutableListOf<StockObserver>()
    private var count = 0;
    private fun update() {
        observerList.forEach {
            it.updated()
        }
    }

    fun add(observer: StockObserver) {
        observerList.add(observer)
    }

    fun remove(observer: StockObserver) {
        observerList.remove(observer)
    }

    fun onStockUpdated(count: Int) {
        update()
        this.count = count
    }
}

class TataStock : StockObserver {
    override fun updated() {
        println("tata stock updated")
    }
}

class BataStock : StockObserver {
    override fun updated() {
        println("bata stock updated")
    }
}

fun main() {

    val stockObservable = StockObservable()
    val tataStock = TataStock()
    val bataStock = BataStock()
    stockObservable.add(tataStock)
    stockObservable.add(bataStock)
    for (x in 1..5) {
        stockObservable.onStockUpdated(x)
    }

    val testLivedata = LiveData<String>()
    testLivedata.observe {
        println("Observer Updated")
    }
    testLivedata.setValue("Suraj")
    testLivedata.setValue("Suraj")
}


class LiveData<T> {

    private val observerList = mutableListOf<(T?) -> Unit>()
    private var _value: T? = null

    fun setValue(value: T) {
        _value = value
        update()
    }

    fun getValue(): T? {
        return _value
    }

    private fun update() {
        observerList.forEach {
            it.invoke(_value)
        }
    }


    fun observe(observer: (T?) -> Unit) {
        observerList.add(observer)
    }

}