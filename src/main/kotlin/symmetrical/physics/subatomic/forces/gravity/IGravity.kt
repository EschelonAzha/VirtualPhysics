package symmetrical.physics.subatomic.forces.gravity

import kotlin.reflect.KClass

interface IGravity {
    fun attract                 (item:Any)              : IGravity
    fun eject                   (item:Any)              : IGravity
    fun getGravitationalField   ()                      : IGravitationalField
    fun getGravity              ()                      : IGravity
    fun gravitateTo             (kClass: KClass<*>)     : Any?
    fun orbit                   (gravity:IGravity)      : IGravity

    fun setSelf                 (gravity:IGravity)      : IGravity
}