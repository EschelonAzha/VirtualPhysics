package symmetrical.electronics.components

import symmetrical.cosmic.physics.atomic.atoms.Atom
import symmetrical.cosmic.physics.subatomic.matter.hadrons.baryons.Proton
import symmetrical.electronics.interfaces.ICapacitor

// for more information see:   https://en.wikipedia.org/wiki/Capacitor

class Capacitor : ICapacitor {

    private lateinit var atom:Atom

    override fun capacitor(atom: Atom) : Unit {
        val me : Proton = this.atom.getValueProton()
        val you: Proton = atom.getValueProton()

        me.ionicBond(you)
    }

    override fun capacitor_(atom: Atom) : Atom {
        capacitor(atom);
        return atom
    }
    override fun _capacitor(atom: Atom) : Atom {
        capacitor(atom);
        return this.atom
    }

    override fun setAtom(atom:Atom) : Atom {
        this.atom = atom
        return this.atom
    }
}