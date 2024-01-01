package symmetrical.cosmic._physics._subatomic.matter.leptons

import symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons.AntiNeutrino
import symmetrical.cosmic._physics._subatomic.spacial.ParticleBeam
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter
/*
https://en.wikipedia.org/wiki/Neutrino
 */

class Neutrino(
    private val matter: IMatter = Matter(Neutrino::class, AntiNeutrino::class),
) : Lepton(),
    IMatter by matter
{
    constructor() : this(
        Matter(Neutrino::class, AntiNeutrino::class),
    )
    init {

    }

    lateinit var __beam: ParticleBeam
    // lateinit var weakRef: WeakRef<Particle>



    override fun getClassId() : String {
        return matter.getClassId()
    }

//    fun getOrigin(): Particle? {
//        val particle = weakRef.get()
//        if (particle == null) {
//            __beam.remove(this)
//        }
//        return particle
//    }

//    fun setOrigin(beam: ParticleBeam, particle: Particle): Neutrino {
//        this.__beam = beam;
//        this.weakRef = WeakReference(particle)
//        __beam.add(this)
//        return this
//    }
}