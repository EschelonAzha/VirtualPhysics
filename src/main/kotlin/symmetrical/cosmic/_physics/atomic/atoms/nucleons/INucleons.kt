package symmetrical.cosmic._physics.atomic.atoms.nucleons


import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Neutron
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Proton
import symmetrical.cosmic._physics.atomic.atoms.Atom

interface INucleons {

    fun addNeutron      (proton: Neutron)   : Neutron
    fun addProton       (proton: Proton)    : Proton
    fun findNeutron     (purpose:String)    : Int
    fun getAtomicNumber ()                  : Int
    fun getClassId      ()                  : String
    fun getNeutron      (pos:Int)           : Neutron
    fun getNeutron      (purpose:String)    : Neutron
 //   fun getProton       (pos:Int)           : Proton
    fun getValueProton  ()                  : Proton
    fun setAtom         (atom: Atom)        : Atom
    fun setAtomicNumber (number:Int)        : Nucleons

    fun wind            (purpose:String)    : Nucleons
}