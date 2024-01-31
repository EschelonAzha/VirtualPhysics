package symmetrical.electronics

import symmetrical.cosmic.physics.atomic.atoms.Atom

interface IElectronics : ICapacitor {


    fun conductor_(atom: Atom, autoFlow:Boolean=true) : Atom
    fun _conductor(atom: Atom, autoFlow:Boolean=true) : Atom
    fun conductor(atom: Atom, autoFlow:Boolean=true) : Unit
    fun diode_(atom:Atom, autoFlow:Boolean=true) : Atom
    fun _diode(atom:Atom, autoFlow:Boolean=true) : Atom
    fun diode(atom:Atom, autoFlow:Boolean=true) : Unit
    override fun setAtom(atom: Atom) : Atom


}