package applications.tests.dictionary.atoms

import symmetrical.physics.atomic.atoms.Atom
import symmetrical.physics.atomic.atoms.elements.Hydrogen
import symmetrical.physics.subatomic.matter.bosons.ZBoson
import symmetrical.physics.subatomic.matter.hadrons.baryons.Proton
import symmetrical.physics.subatomic.matter.quarks.Down

class Capacitor : symmetrical.physics.atomic.atoms.elements.Hydrogen() {

    fun with(content:String) : Capacitor {
        super.with(content)
        return this
    }

    override fun capacitanceChange(me: symmetrical.physics.subatomic.matter.hadrons.baryons.Proton, valueQuark: Down, zBoson: symmetrical.physics.subatomic.matter.bosons.ZBoson) : symmetrical.physics.subatomic.matter.bosons.ZBoson {
        return zBoson
    }
}