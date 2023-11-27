package symmetrical.cosmic._physics._subatomic.matter.leptons

import symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons.AntiNeutrino
import symmetrical.cosmic._physics._subatomic.spacial.ParticleBeam
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter


class Neutrino(
    private val antiMatter: IAntiMatter = AntiMatter(Neutrino::class),
) : Lepton(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(Neutrino::class),
    )
    init {
        setAntiMatter(AntiNeutrino::class)
    }

    lateinit var __beam: ParticleBeam
    // lateinit var weakRef: WeakRef<Particle>



    override fun getClassId() : String {
        return antiMatter.getClassId()
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