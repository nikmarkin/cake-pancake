package cakepancake.api.v1.models



import ch.qos.logback.core.net.server.Client
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.javatime.date


object Product : IntIdTable() {
    val order=reference("order", Orders)
    val master=reference("master", Users).nullable()
    val creationDate=date("register_date")
    val progressDate=date("progress_date")
    val finishDate=date("finish_date")
    val closeDate=date("close_date")
    val name=varchar("name", 255)
    val keyIngredients=varchar("key_ingredients", 255)
    val description=varchar("description", 255)
    val image=varchar("image", 255)


}


//data class Orders(val id:Int,val name:String,val registerDate:Long)