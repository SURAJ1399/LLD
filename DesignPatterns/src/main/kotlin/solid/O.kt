package solid


class SaveDataWithoutOCP() {
    fun save(operation: Int) {
        when (operation) {
            1 -> SavetoSQLDb2().save()
            else -> SavetoMongoDb2().save()
        }

    }
}

class SavetoSQLDb2() {
    fun save() {
        println("saved to sql db")
    }
}

class SavetoMongoDb2() {
    fun save() {
        println("saved to mongo db")
    }
}

/** If in future we need to another method like saveToLocal inside saveDataWithoutOCP class  we need to modify the file which is a bad idea .
 *
 */


class SaveDataWithOCP() {
    fun save(iSave: ISave2) {
        iSave.save()
    }
}

interface ISave2 {
    fun save()
}


class SaveToSqlDb2 : ISave2 {
    override fun save() {
        println("saved to sql db")
    }

}


class SaveToMongoDb2 : ISave2 {
    override fun save() {
        println("saved to mongo db")
    }

}


class SaveToLocalFile2 : ISave2 {
    override fun save() {
        println("saved to local db")
    }
}


fun main() {
    val saveData = SaveDataWithOCP()
    saveData.save(SaveToMongoDb2())
    saveData.save(SaveToLocalFile2())

}
