package symmetrical.cosmic._physics.atomic.atoms.orbitals

import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin.Spin
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.matter.bosons.ZBoson
import symmetrical.cosmic._physics._subatomic.matter.leptons.Electron
import symmetrical.cosmic._physics.atomic.atoms.Atom
/*
https://en.wikipedia.org/wiki/Atomic_orbital
 */
interface IOrbitals {

    fun electronSpin            ()              : Boolean
    fun electronValue           ()              : Any?
    fun electronValueStr        ()              : String
    fun getClassId              ()              : String
    fun getElectronPhoton       ()              : Photon
    fun getElectronSpin         ()              : Spin
    fun getElectronValue        ()              : Electron
    fun getElectronWavelength   ()              : Any?

    fun setAtom                 (atom: Atom)    : Atom
    fun setElectronSpin         (spin: Spin)    : Atom
    fun setElectronValue        (value:Any?)    : ZBoson

}