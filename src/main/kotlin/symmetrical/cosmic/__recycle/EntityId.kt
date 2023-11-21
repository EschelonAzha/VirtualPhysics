package symmetrical.cosmic.__recycle

import kotlin.reflect.KClass

class EntityId {
    val id:String
    val kClass:KClass<*>
    constructor(id:String, kClass: KClass<*>) {
        this.id = id
        this.kClass = kClass
    }

    override fun toString() : String {
        return "["+id+":"+kClass.simpleName+"]"
    }
}