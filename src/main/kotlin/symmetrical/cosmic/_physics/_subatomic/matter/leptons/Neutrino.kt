package symmetrical.cosmic._physics._subatomic.matter.leptons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion


class Neutrino(
    private val fermion: IFermion = Fermion(),
) : Lepton(),
    IFermion by fermion
{
    constructor() : this(
        Fermion()
    )

    lateinit var __beam: ParticleBeam
    // lateinit var weakRef: WeakRef<Particle>



    private fun getLocalClassId(): String {
        return Absorber.getClassId(Neutrino::class)
    }

    override fun getClassId(): String {
        return getLocalClassId()
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