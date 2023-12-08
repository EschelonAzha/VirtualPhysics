package symmetrical.cosmic._physics._subatomic.luminescent

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.spacial.ParticleBeam
import symmetrical.cosmic._physics._subatomic.spacial.IParticleBeam
import kotlin.reflect.KClass

class AntiMatter : MatterAntiMatter, IAntiMatter {
    constructor(positive:KClass<*>, negative:KClass<*>, jumby:Boolean) : super(positive, negative){

    }
}