package symmetrical.cosmic._physics.atomic.atoms.nucleons

import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Neutron
/*
https://en.wikipedia.org/wiki/Neutron
 */

interface INeutrons {
    fun absorb      (photon: Photon)     : Photon
    fun addNeutron  (neutron: Neutron)  : Neutron
    fun emit        ()                  : Photon
    fun findNeutron (purpose:String)    : Int
    fun getClassId  ()                  : String
    fun getNeutron  (pos:Int)           : Neutron
    fun getNeutron  (purpose:String)    : Neutron
    fun setNucleons (nucleons:Nucleons) : Nucleons
}