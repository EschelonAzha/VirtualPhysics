package symmetrical.cosmic._physics._subatomic.luminescent

import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.spacial.IParticleBeam

interface IMatterAntiMatter {
    fun annihilate      ()                  : Photon
    fun check           (photon: Photon)    : Unit
    fun getClassId      ()                  : String
    fun getIlluminations()                  : IParticleBeam
}