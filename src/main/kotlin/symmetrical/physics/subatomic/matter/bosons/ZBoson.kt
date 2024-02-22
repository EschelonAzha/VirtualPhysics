package symmetrical.physics.subatomic.matter.bosons
/*
 * This file is part of Virtual Physics.
 *
 * Copyright (C) [2024] Stephen R. DeSofi AKA Eschelon Azha
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import symmetrical.physics.subatomic.balanced.pairs.TauAntiTauPair
import symmetrical.physics.subatomic.balanced.values.Field
import symmetrical.physics.subatomic.matter.hadrons.baryons.Proton
import symmetrical.physics.subatomic.matter.quarks.Quark


// For more information visit:   https://en.wikipedia.org/wiki/W_and_Z_bosons

open class ZBoson(){

    // Neutral Charge
    // Spin 1
    // This boson transfers its spin, momentum and energy

    private var accepted     :Boolean   = true
    private var constructing :Boolean   = false
    private var newValue     :Field     = Field();
    private var oldValue     :Field     = Field()
    private var reason       :String    = ""
    private var reasonCode   :Int       = 0



    fun with(newValue: Field, constructing:Boolean = false) : ZBoson {
        this.newValue     = newValue
        this.constructing = constructing
        return this
    }
    fun decay() : TauAntiTauPair {
        return TauAntiTauPair().with(accepted, reasonCode, reason, newValue, oldValue)
    }
    fun getNewField() : Field {
        return this.newValue;
    }
    fun getNewValue() : Any? {
        return getNewField().getContent()
    }

    fun getOldField() : Field {
        return this.oldValue
    }
    fun getOldValue() : Any? {
        return getOldField().getContent()
    }
    fun mediate(proton: Proton) : ZBoson {

        val constraints: Quark = proton.getConstraintsQuark()
        return constraints.mediate(proton.getValueQuark(), proton.getConstraintsQuark(), this)
    }
    fun isAccepted() : Boolean {
        return accepted
    }
    fun isConstructing() : Boolean {
        return constructing
    }
    fun setAccepted(accepted:  Boolean) : ZBoson {
        this.accepted = accepted
        return this
    }
    fun setNewValue(content:Any?) : ZBoson {
        this.newValue.setContent(content)
        return this
    }
    fun setOldValue(content:Any?) : ZBoson {
        this.oldValue.setContent(content)
        return this
    }
    fun setReason(reason:String) : ZBoson {
        this.reason = reason
        return this
    }
    fun setReasonCode(code:Int) : ZBoson {
        this.reasonCode = code
        return this
    }
}