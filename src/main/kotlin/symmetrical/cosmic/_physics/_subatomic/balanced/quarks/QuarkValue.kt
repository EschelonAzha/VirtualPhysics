package symmetrical.cosmic._physics._subatomic.balanced.quarks

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.angularMomentum.AngularMomentum
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.angularMomentum.CRLFTerminatedMomentum
import symmetrical.cosmic._physics._subatomic.matter.bosons.ZBoson
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin.Spin
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics.atomic.atoms.nucleons.Nucleons
import symmetrical.cosmic._physics.atomic.atoms.nucleons.Protons

class QuarkValue  : IQuarkValue {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    lateinit var atom:Atom
    constructor() {

    }
    public fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(QuarkValue::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun setAtom(atom: Atom) : Atom {
        this.atom = atom
        return atom
    }
    override fun quarkSpin() : String {
        val quark   = atom.nucleons.getValueProton().get(0) as Quark
        return quark.spin()
    }
    override fun quarkValue() : Any? {
        val nucleons: Nucleons = atom.nucleons
        val protons : Protons = nucleons.protons
        val quark   = protons.getValueProton().get(0) as Quark
        return quark.getValue()
    }
    override fun quarkValueStr() : String {
        return quarkValue().toString()
    }
    override fun setQuarkMomentum(momentum: AngularMomentum): Atom {
        val quark   = atom.nucleons.getValueProton().get(0) as Quark
        quark.setMomentum(momentum)
        return atom
    }
    override fun setQuarkSpin(spin: Spin) : Atom {
        val quark   = atom.nucleons.getValueProton().get(0) as Quark
        quark.setSpin(spin)
        return atom
    }
    override fun setQuarkValue(value:Any?) : ZBoson {
        val zBoson = Quark.Args(value)
        val quark   = atom.nucleons.getValueProton().get(0) as Quark
        return quark.z(zBoson)
    }
}