package symmetrical.electronics

import symmetrical.cosmic.physics.atomic.atoms.Atom
import symmetrical.cosmic.physics.subatomic.matter.hadrons.baryons.Proton

class Electronics(
    val capacitor:ICapacitor = Capacitor()
) :
    ICapacitor by capacitor,
    IElectronics
{
    lateinit var atom: Atom


    override fun diode(atom: Atom, autoFlow:Boolean) : Unit {
        val me : Proton = this.atom.getValueProton()
        val you: Proton = atom.getValueProton()

        me.covalentBond(you, autoFlow)
    }

    override fun setAtom(atom:Atom) : Atom {
        this.atom = atom
        capacitor.setAtom(atom)
        return atom
    }

    override fun conductor_(atom: Atom, autoFlow:Boolean) : Atom {
        conductor(atom, autoFlow);
        return atom
    }
    override fun _conductor(atom: Atom, autoFlow:Boolean) : Atom {
        conductor(atom, autoFlow);
        return this.atom
    }
    override fun conductor(atom: Atom, autoFlow:Boolean) : Unit {
        diode(atom, autoFlow)
        atom.diode(this.atom, autoFlow)
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