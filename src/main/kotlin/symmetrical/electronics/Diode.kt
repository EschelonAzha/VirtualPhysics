package symmetrical.electronics

import symmetrical.cosmic.physics.atomic.atoms.Atom
import symmetrical.cosmic.physics.subatomic.matter.hadrons.baryons.Proton

class Diode : IDiode {

    private lateinit var atom: Atom

    override fun setAtom(atom: Atom) : Atom {
        this.atom = atom
        return this.atom
    }
    override fun diode(atom: Atom, autoFlow:Boolean) : Unit {
        val me : Proton = this.atom.getValueProton()
        val you: Proton = atom.getValueProton()

        me.covalentBond(you, autoFlow)
    }
    override fun diode_(atom: Atom, autoFlow:Boolean) : Atom {
        diode(atom, autoFlow)
        return atom
    }
    override fun _diode(atom: Atom, autoFlow:Boolean) : Atom {
        diode(atom, autoFlow)
        return this.atom
    }
}