package symmetrical.electronics

import symmetrical.cosmic.physics.atomic.atoms.Atom

interface IElectronics : ICapacitor, IDiode {


    fun conductor_(atom: Atom, autoFlow:Boolean=true) : Atom
    fun _conductor(atom: Atom, autoFlow:Boolean=true) : Atom
    fun conductor(atom: Atom, autoFlow:Boolean=true) : Unit

    override fun setAtom(atom: Atom) : Atom


}