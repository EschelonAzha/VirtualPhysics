package symmetrical.physics.subatomic.forces.gravity

import symmetrical.physics.subatomic.spacial.Beam
import symmetrical.physics.subatomic.spacial.ParticleBeam
import kotlin.reflect.KClass

interface IGravitationalField {

    fun attract         (item:Any)                          : GravitationalField
    fun deorbit         ()                                  : GravitationalField
    fun eject           (item:Any)                          : GravitationalField
    fun gravitate       (kClass: KClass<*>)                 : Any?
    fun gravitateAll    (kClass: KClass<*>, result:Beam)    : Beam
    fun orbit           (orbits:IGravitationalField)        : GravitationalField

    fun setGravity      (gravity:IGravity)                  : GravitationalField

}