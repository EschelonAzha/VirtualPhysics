package websites.tests.alloys

import symmetrical.cosmic._physics.atomic.substance.Substance


class _Left : Left {
    var derived = ArrayList<Substance>()


    var _content:String = "Left"

    override fun addDerived(substance:Substance) : Substance {
        //   this.derived.add(substance);
        return this;
    }
    override fun getContent() : String {
        return this._content;
    }
    override fun getLeftContent() : String {
        return this._content
    }
    override fun setLeftContent(content:String) : Left {
        this._content = content;
        return this
    }
    override fun start() : Unit {
        this.run()
    }
    override fun run() : Unit {
        println("left running")
    }
}