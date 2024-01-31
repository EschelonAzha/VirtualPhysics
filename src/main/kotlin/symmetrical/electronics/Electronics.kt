package symmetrical.electronics

import symmetrical.cosmic.physics.atomic.atoms.Atom
import symmetrical.cosmic.physics.subatomic.matter.hadrons.baryons.Proton

class Electronics(
    val capacitor:ICapacitor = Capacitor(),
    val diode    :IDiode     = Diode(),

) :
    ICapacitor by capacitor,
    IDiode     by diode,
    IElectronics
{
    lateinit var atom: Atom

    override fun setAtom(atom:Atom) : Atom {
        this.atom = atom
        capacitor.setAtom(atom)
        diode.setAtom(atom)
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
}