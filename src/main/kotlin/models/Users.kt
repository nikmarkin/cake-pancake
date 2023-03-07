package cakepancake.api.v1.models


import cakepancake.api.v1.models.User.Companion.referrersOn
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.javatime.date


object Users : IntIdTable() {
    val email=varchar("email",255)
    val registerDate=date("registerDate")
    val firstname =varchar("firstname",255)
    val lastname=varchar("lastname",255)
    var password=varchar("password", 255)



}
class User(id: EntityID<Int>): IntEntity(id) {
    companion object : IntEntityClass<User>(Users)
    var email by Users.email
    var password by Users.password
    var registerDate by Users.registerDate
    var firstname by Users.firstname
    var lastname by Users.lastname
    val orders by UserOrder referrersOn UserOrders.order

}

