package symmetrical.cosmic._physics.atomic.atoms.states.strings

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic._physics.atomic.atoms.Atom


open class QString : Atom {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    init {
        setString("")
    }
    constructor() {
    }
    constructor(value:String) : this() {
        setString(value)
    }
    public override fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    override fun absorb(photon: Photon) : Photon {
        return super.absorb(photon.propagate())
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return getLocalClassId()+super.emit().radiate()
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(QString::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun red() : String {
        return nucleons.getValueProton().red() as String
    }
    fun setString(value:String) : QString {
        setQuarkValue(value)
        return this
    }
}