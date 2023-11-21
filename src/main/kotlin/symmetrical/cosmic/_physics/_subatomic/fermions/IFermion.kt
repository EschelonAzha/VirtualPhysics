package symmetrical.cosmic._physics._subatomic.fermions

import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import kotlin.reflect.KClass

interface IFermion {
    fun getClassId()            : String
    fun getIlluminations()      : ParticleBeam
    fun setKClass(kClass: KClass<*>) : IFermion
}