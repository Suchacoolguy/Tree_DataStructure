// Traverse 할 때 StringBuilder를 받아서 거기다가 스트링으로 저장함.
// 이렇게 하면 Print 하나로 문제 1번부터 3번까지 트리로 출력 가능.
//  (Traverse 하면서 만든 String을 받아서 그걸 사용하는 Print 함수를 만드는 것)

public class CBT_array extends SuperTree {
    Object[] arr;
    int size;
    
    public CBT_array(int numOfNodes)
    {
        size = numOfNodes;
        arr = new Object[size + 1];
        
        for (int idx = 0; idx < size; idx++)        // 루트를 0, 왼쪽 자식은 루트 * 2 + 1, 오른쪽 자식은 루트 * 2 + 2로 설정했음.
        {
            arr[idx] = test.decimalToAlphabetBase(idx);     // 문제 1번, 노드 개수만큼 알파벳 A로 시작하는 노드들 만들어 배열(트리)에 입력
        }
    }

    public void preOrderTraverse(StringBuilder sb, int nodeNum) 
    {
        if (nodeNum < size && arr[nodeNum] != null) 
        {
            sb.append(arr[nodeNum]);
            sb.append("\n");
            preOrderTraverse(sb, nodeNum * 2 + 1);
            preOrderTraverse(sb, nodeNum * 2 + 2);
        }
    }

    public void inOrderTraverse(StringBuilder sb, int nodeNum) 
    {
        if (nodeNum < size && arr[nodeNum] != null) {
            inOrderTraverse(sb, nodeNum * 2 + 1);
            sb.append(arr[nodeNum]);
            sb.append("\n");
            inOrderTraverse(sb, nodeNum * 2 + 2);
        }
    }

    public void postOrderTraverse(StringBuilder sb, int nodeNum) 
    {
        if (nodeNum < size && arr[nodeNum] != null) {
            postOrderTraverse(sb, nodeNum * 2 + 1);
            postOrderTraverse(sb, nodeNum * 2 + 2);
            sb.append(arr[nodeNum]);
            sb.append("\n");
        }
    }

    public void levelOrderTraverse(StringBuilder sb, int nodeNum)
    {
        CircularQueue cQueue = new CircularQueue();
        for (int i = nodeNum; i < size; i++)
        {
            cQueue.enQueue(arr[i]);
        }

        while (cQueue.getSize() != 0)
        {
            sb.append(cQueue.deQueue());
            sb.append("\n");
        }
    }
}
