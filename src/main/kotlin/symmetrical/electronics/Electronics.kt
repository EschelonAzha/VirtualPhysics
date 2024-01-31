package symmetrical.electronics

import symmetrical.cosmic.physics.atomic.atoms.Atom
import symmetrical.electronics.components.Capacitor
import symmetrical.electronics.components.Conductor
import symmetrical.electronics.components.Diode
import symmetrical.electronics.interfaces.ICapacitor
import symmetrical.electronics.interfaces.IConductor
import symmetrical.electronics.interfaces.IDiode


class Electronics(
    private val capacitor: ICapacitor   = Capacitor(),
    private val diode    : IDiode       = Diode(),
    private val conductor: IConductor   = Conductor()
) :
    ICapacitor  by capacitor,
    IDiode      by diode,
    IConductor  by conductor,
    IElectronics
{
    override fun setAtom(atom:Atom) : Atom {
        capacitor.setAtom(atom)
        conductor.setAtom(atom)
        diode.setAtom(atom)
        return atom
    }
}