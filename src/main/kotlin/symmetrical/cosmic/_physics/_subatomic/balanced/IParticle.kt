package symmetrical.cosmic._physics._subatomic.balanced

import kotlin.reflect.KClass


interface IParticle {
    fun createUniqueId()                    : IParticle
    fun getAntiMatter()                     : KClass<*>
    fun getUniqueId   ()                    : String
    fun getClassId    ()                    : String
    fun getSelf       ()                    : IParticle
    fun setAntiMatter (antiMatter:KClass<*>): IParticle
    fun setSelf       (self: IParticle)     : IParticle
}