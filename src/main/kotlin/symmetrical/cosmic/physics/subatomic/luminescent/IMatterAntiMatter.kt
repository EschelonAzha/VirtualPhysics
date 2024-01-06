package symmetrical.cosmic.physics.subatomic.luminescent

import symmetrical.cosmic.physics.subatomic.bosons.Photon
import symmetrical.cosmic.physics.subatomic.spacial.IParticleBeam
/*
https://en.wikipedia.org/wiki/Annihilation
 */
interface IMatterAntiMatter {
    fun annihilate      ()                  : Photon
    fun check           (photon: Photon)    : Unit
    fun getClassId      ()                  : String
    fun getIlluminations()                  : IParticleBeam
}