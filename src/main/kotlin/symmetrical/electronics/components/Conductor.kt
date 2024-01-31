package symmetrical.electronics.components

import symmetrical.cosmic.physics.atomic.atoms.Atom
import symmetrical.electronics.interfaces.IConductor

// for more information see:   https://en.wikipedia.org/wiki/Mixed_conductor
class Conductor : IConductor {

    private lateinit var atom:Atom

    override fun conductor_(atom: Atom, autoFlow:Boolean) : Atom {
        conductor(atom, autoFlow);
        return atom
    }
    override fun _conductor(atom: Atom, autoFlow:Boolean) : Atom {
        conductor(atom, autoFlow);
        return this.atom
    }
    override fun conductor(atom: Atom, autoFlow:Boolean) : Unit {
        this.atom.diode(atom, autoFlow)
        atom.diode(this.atom, autoFlow)
    }

    override fun setAtom(atom:Atom) : Atom {
        this.atom = atom
        return this.atom
    }
}