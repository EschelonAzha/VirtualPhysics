package symmetrical.cosmic._physics._subatomic.balanced.fundamentals.wavelength

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.values.Field
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.*
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Proton
import symmetrical.cosmic._physics._subatomic.matter.quarks.Quark
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic.dictionary.protons.ValueProton
import kotlin.reflect.KClass
/*
https://en.wikipedia.org/wiki/Wavelength
 */
class Wavelength(
    private val _field:QuasiParticle=QuasiParticle()
) :
    IQuasiParticle by _field {

    constructor() : this(
        QuasiParticle()
    )

    fun i() : Wavelength {
        return this
    }

    companion object {
        fun content(atom: Atom) : Any? {
            return content(atom.getProton(ValueProton::class))
        }
        fun content(atom: Atom, kClass: KClass<*>) : Any? {
            return content(atom.getProton(kClass))
        }
        fun content(proton:Proton) : Any? {
            var quark  : Quark = proton.getValueQuark()
            return quark.getWavelength().getField().getContent()
        }
        fun field(atom: Atom) : Field {
            return field(atom.getProton(ValueProton::class))
        }
        fun field(atom: Atom, kClass: KClass<*>) : Field {
            return field(atom.getProton(kClass))
        }
        fun field(proton: Proton) : Field {
            var quark  : Quark = proton.getValueQuark()
            return quark.getWavelength().getField()
        }
        fun format(atom: Atom) : Field {
            val proton = atom.getProton(ValueProton::class)
            var quark  : Quark = proton.getValueQuark()
            return quark.getAngularMomentum().run(field(atom))
        }
    }

    override fun absorb(photon: Photon) : Photon {
        var remainder = photon.propagate()
        remainder = _field.absorb(remainder)
        return remainder
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }
    public fun getClassId() : String {
        return getLocalClassId()
    }
    fun getField() : Field {
        return _field.getField()
    }

    fun getQuantumField() : QuasiParticle {
        return _field
    }

    private fun radiate() : String {
        return getLocalClassId()+
                _field.emit().radiate()
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(Wavelength::class)
    }
    fun setWavelength(value:Any?) : Any? {
        return setContent(value)
    }
    fun wavelength() : Any? {
        return _field.getContent()
    }


}