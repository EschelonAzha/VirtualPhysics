package symmetrical.cosmic._physics._subatomic.fermions

import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import kotlin.reflect.KClass

interface IFermion {
    fun getAbsorberId()         : String
//    fun getClassId()            : String
    fun getIlluminations()      : ParticleBeam
    fun setSelf(self: Particle) : IFermion
    fun setKClass(kClass: KClass<*>) : IFermion
}