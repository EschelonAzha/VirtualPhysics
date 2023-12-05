package symmetrical.cosmic._physics._subatomic.balanced

import kotlin.reflect.KClass


interface IParticle {
    fun createUniqueId()                    : IParticle
    fun getUniqueId   ()                    : String
    fun getClassId    ()                    : String
    fun getSelf       ()                    : IParticle
    fun setSelf       (self: IParticle)     : IParticle
}