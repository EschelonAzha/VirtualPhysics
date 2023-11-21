package symmetrical.cosmic._physics._subatomic.balanced.quarks

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.angularMomentum.AngularMomentum
import symmetrical.cosmic._physics._subatomic.matter.bosons.ZBoson
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin.Spin
import symmetrical.cosmic._physics._subatomic.matter.quarks.Quark
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics.atomic.atoms.nucleons.Nucleons
import symmetrical.cosmic._physics.atomic.atoms.nucleons.Protons
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class QuarkValue(
    private val fermion: IFermion = Fermion(QuarkValue::class),
)  :
    IFermion by fermion,
    IQuarkValue
{
    constructor() : this(
        Fermion(QuarkValue::class),
    )
    lateinit var atom:Atom


    override fun getClassId() : String {
        return fermion.getClassId()
    }
    override fun setAtom(atom: Atom) : Atom {
        this.atom = atom
        return atom
    }
    override fun quarkMomentum() : String {
        val quark   = atom.nucleons.getValueProton().get(0) as Quark
        return quark.momentum()
    }
    override fun quarkSpin() : Boolean {
        val quark   = atom.nucleons.getValueProton().get(0) as Quark
        return quark.spin()
    }
    override fun quarkValue() : Any? {
        val nucleons: Nucleons = atom.nucleons
        val protons : Protons = nucleons.getProtons()
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