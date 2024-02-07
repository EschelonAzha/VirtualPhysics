package applications.tests.dictionary.atoms

import symmetrical.physics.atomic.atoms.Atom
import symmetrical.physics.atomic.atoms.elements.Hydrogen
import symmetrical.physics.subatomic.matter.bosons.ZBoson
import symmetrical.physics.subatomic.matter.hadrons.baryons.Proton
import symmetrical.physics.subatomic.matter.quarks.Down

class Capacitor : Hydrogen() {

    fun with(content:String) : Capacitor {
        super.with(content)
        return this
    }

    override fun capacitanceChange(me: Proton, valueQuark: Down, zBoson: ZBoson) : ZBoson {
        return zBoson
    }
}