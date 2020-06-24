package com.grupyedi.webservice.datastructures;

public class ListGraph {

    Node head;
    boolean isDirected;
    int size;
    int realSize;

    public static void main(String[] args) {
    }

    ListGraph(boolean isDirected){
        head = null;
        size = 0;
        realSize = 0;
        this.isDirected = isDirected;
    }

    public boolean testUndirectedAddingFindingAndDeleting(){
        ListGraph lg = new ListGraph(false);
        System.out.println("\nTestings For Undirected Graph:");
        lg.insert(new Edge(3,5));
        lg.insert(new Edge(3,7));
        lg.insert(new Edge(3,2));
        lg.insert(new Edge(2,7));
        lg.insert(new Edge(1,5));
        lg.insert(new Edge(4,5));
        lg.insert(new Edge(2,5));
        System.out.println(lg);
        System.out.println("Finding Edges: " + lg.findEdge(new Edge(1,5)).data.toString() +" "+ lg.findEdge(new Edge(3,7)).data.toString());
        lg.delete(new Edge(2,5));
        lg.delete(new Edge(3,7));
        System.out.println("Graph After Deletions:\n" + lg);
        return true;
    }

    public boolean testDirectedAddingFindingAndDeleting(){
        ListGraph lg = new ListGraph(true);
        System.out.println("\nTestings For Directed Graph:");
        lg.insert(new Edge(3,5));
        lg.insert(new Edge(3,7));
        lg.insert(new Edge(3,2));
        lg.insert(new Edge(2,7));
        lg.insert(new Edge(1,5));
        lg.insert(new Edge(4,5));
        lg.insert(new Edge(2,5));
        System.out.println(lg);
        System.out.println("Finding Edges: " + lg.findEdge(new Edge(1,5)).data.toString() +" "+ lg.findEdge(new Edge(3,7)).data.toString());
        lg.delete(new Edge(2,5));
        lg.delete(new Edge(3,7));
        System.out.println("Graph After Deletions:\n" + lg);
        return true;
    }

    class Node{
        Node rprev;
        Node rnext;
        Node cprev;
        Node cnext;
        Edge data;

        Node(Edge data){
            rprev = null;
            rnext = null;
            cprev = null;
            cnext = null;
            this.data = data;
        }

        Node(Node [] adj, Edge data){
            rprev = adj[0];
            rnext = adj[1];
            cprev = adj[2];
            cnext = adj[3];
            this.data = data;
        }
    }

    public void insert(Edge data){
        if(isDirected){
            realInsert(data);
        }else{
            realInsert(data);
            realInsert(new Edge(data.getDest(), data.getSource(), data.getWeight()));
        }
    }

    /**
     *
     * @param data to insert in the list
     */
    private void realInsert(Edge data) {
        ++realSize;
        Node adj [] = new Node [4];
        for(Node n : adj)
            adj = null;

        if(head == null) {
            head = new Node(data);
            ++size;
            head.rnext = new Node(data);
            head.rnext.rprev = head;
            return;
        }

        Node found = findEdge(data);
        Node nnew = new Node(data);
        int once = 0;

        if(found != null) {
            nnew.rprev = found;
            nnew.rnext = found.rnext;
            found.rnext = nnew;
            if(nnew.rnext != null)
                nnew.rnext.rprev = nnew;
        }else {
            found = new Node(data);
            found.cnext = head;
            once = 0;
            while(found.cnext != null) {
                ++once;
                if(found.cnext.data.getSource() > data.getSource())
                    break;
                found = found.cnext;
            }
            Node created = new Node(data);
            if(once == 1 && head.data.getSource() > data.getSource()) {
                created.cnext = head;
                head.cprev = created;
                head = created;
                head.rnext = new Node(data);
                head.rnext.rprev = head;
                ++size;
            }else {
                created.cnext = found.cnext;
                created.cprev = found;
                found.cnext = created;
                created.rnext = new Node(data);
                created.rnext.rprev = created;
                ++size;
            }
        }

    }

    /**
     *
     * @param target the edge to find in the list
     * @return the found node; else null
     */
    public Node findEdge(Edge target) {
        Node tmp = head;
        boolean success = false;

        while(tmp != null){
            if(tmp.data.getSource() == target.getSource()) {
                success = true;
                break;
            }
            tmp = tmp.cnext;
        }
        if(success) {
            while(tmp.rnext != null) {
                if(tmp.rnext.data.getDest() >= target.getDest())
                    break;
                tmp = tmp.rnext;
            }
            return tmp;
        }

        return null;
    }

    public boolean delete(Edge target){
        if(isDirected){
            return realDelete(target) != null;
        }else{
            realDelete(target);
            return realDelete(new Edge(target.getDest(), target.getSource(), target.getWeight())) != null;
        }
    }

    /**
     *
     * @param target edge to delete from the list
     * @return the deleted node; else false
     */
    private Node realDelete(Edge target) {
        Node tmp = findEdge(target);
        if(tmp != null) {
            tmp = tmp.rnext;
            Node before = tmp.rprev;
            before.rnext = tmp.rnext;
            if(before.rnext != null)
                before.rnext.rprev = before;
            tmp.rprev = tmp.rnext = null;
        }
        return tmp;
    }

    @Override
    /**
     * @return String the string that identifies the list
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(size == 0) {
            sb.append("Empty");
            return sb.toString();
        }
        Node tmp = head;
        Node inner;

        while(tmp.cnext != null) {
            sb.append("Row " + tmp.data.getSource() + " :[");
            inner = tmp.rnext;
            while(inner != null) {
                sb.append(" " + inner.data.toString());
                inner = inner.rnext;
            }
            sb.append(" ]");
            sb.append("-->");
            sb.append("\n");
            tmp = tmp.cnext;
        }
        sb.append("Row " + tmp.data.getSource() + " :[");
        inner = tmp.rnext;
        while(inner != null) {
            sb.append(" " + inner.data.toString());
            inner = inner.rnext;
        }
        sb.append(" ]");

        return sb.toString();
    }
}
