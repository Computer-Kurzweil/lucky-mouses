package org.woehlke.computer.kurzweil.lucky.mouses.model.koch;

import lombok.*;
import org.woehlke.computer.kurzweil.lucky.mouses.model.geometry.LatticePoint;

import java.io.Serializable;
import java.util.Objects;

/**
 * Koch Snowflake. A Fractal with self self-similarity.
 * (C) 2006 - 2022 Thomas Woehlke
 * @author Thomas Woehlke
 *
 * @see LatticePoint
 *
 * @see <a href="https://github.com/Computer-Kurzweil/kochsnowflake">Github Repository</a>
 * @see <a href="https://java.woehlke.org/kochsnowflake/">Maven Project Reports</a>
 */
@Getter
@Setter
@NoArgsConstructor
public class LinkedListNode implements Serializable {

    static final long serialVersionUID = 242L;

    private LatticePoint point;

    private LinkedListNode next;

    public LinkedListNode(LatticePoint point) {
        this.point = point;
        this.next = null;
    }

    public LinkedListNode(LinkedListNode other) {
        this.point = other.getPoint().copy();
        this.next = other.getNext();
    }

    public LinkedListNode copy() {
        LinkedListNode copy = new LinkedListNode(this);
        return copy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LinkedListNode that)) return false;
        return getPoint().equals(that.getPoint());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPoint());
    }

    @Override
    public String toString() {
        return "LinkedListNode{" +
            "point=" + this.point.toString() +
            "next.point=" +  this.next.getPoint().toString() +
            '}';
    }


}
