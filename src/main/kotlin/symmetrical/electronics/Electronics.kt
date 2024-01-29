package symmetrical.electronics

import symmetrical.cosmic.physics.atomic.atoms.Atom
import symmetrical.cosmic.physics.subatomic.matter.hadrons.baryons.Proton

class Electronics() : IElectronics  {
    lateinit var atom: Atom
    override fun setAtom(atom:Atom) : Atom {
        this.atom = atom
        return atom
    }

    override fun capacitor_(atom: Atom) : Atom {
        capacitor(atom);
        return atom
    }
    override fun _capacitor(atom: Atom) : Atom {
        capacitor(atom);
        return this.atom
    }

    override fun capacitor(atom: Atom) : Unit {
        val me : Proton = this.atom.getValueProton()
        val you: Proton = atom.getValueProton()

        me.ionicBond(you)
    }
    override fun _diode(atom: Atom, autoFlow:Boolean) : Atom {
        diode(atom, autoFlow)
        return this.atom
    }
    override fun diode(atom: Atom, autoFlow:Boolean) : Unit {
        val me : Proton = this.atom.getValueProton()
        val you: Proton = atom.getValueProton()

        me.covalentBond(you, autoFlow)
    }

}