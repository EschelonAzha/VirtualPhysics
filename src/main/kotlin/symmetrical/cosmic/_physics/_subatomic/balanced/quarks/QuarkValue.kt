package symmetrical.cosmic._physics._subatomic.balanced.quarks

import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.angularMomentum.AngularMomentum
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin.Spin
import symmetrical.cosmic._physics._subatomic.matter.bosons.ZBoson
import symmetrical.cosmic._physics._subatomic.matter.quarks.Quark
import symmetrical.cosmic._physics.atomic.atoms.nucleons.Nucleons
import symmetrical.cosmic._physics.atomic.atoms.nucleons.Protons
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic.dictionary.protons.ValueProton

class QuarkValue(
    private val matter: IMatter = Matter(QuarkValue::class, QuarkValue::class),
)  :
    IMatter by matter,
    IQuarkValue
{
    constructor() : this(
        Matter(QuarkValue::class, QuarkValue::class),
    )

    lateinit var atom: Atom


    override fun getClassId() : String {
        return matter.getClassId()
    }

    override fun setAtom(atom: Atom) : Atom {
        this.atom = atom
        return atom
    }
    override fun setQuarkMomentum(momentum: AngularMomentum): Atom {
        val quark   = atom.nucleons.getProton(ValueProton::class).get(0) as Quark
        quark.setAngularMomentum(momentum)
        return atom
    }
    override fun setQuarkSpin(spin: Spin) : Atom {
        val quark   = atom.nucleons.getProton(ValueProton::class).get(0) as Quark
        quark.setSpin(spin)
        return atom
    }
    override fun setQuarkValue(value:Any?) : ZBoson {
        val zBoson = Quark.Args(value)
        val quark   = atom.nucleons.getProton(ValueProton::class).get(0) as Quark
        return quark.z(zBoson)
    }
}