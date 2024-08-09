package solid



/*** Single Responsibility Principle: each class should have one responsibility, one single purpose. This means that a class
will do only one job, which leads us to conclude it should have only one reason to change.
* @see https://medium.com/huawei-developers/kotlin-solid-principles-tutorial-examples-192bf8c049dd
 **/

class SaveData() {
    fun toSQLDb() {
        println("saved to sql db")
    }

    fun toMongoDb() {
        println("saved to mongo db")
    }
}

/************************************/


interface ISave {
    fun save()
}


class SaveToSqlDb : ISave {
    override fun save() {
        println("saved to sql db")
    }

}


class SaveToMongoDb : ISave {
    override fun save() {
        println("saved to mongo db")
    }

}
