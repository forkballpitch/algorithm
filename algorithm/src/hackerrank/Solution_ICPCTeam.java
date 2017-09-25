package hackerrank;

import java.util.Scanner;

/**
 * 
 * Problem Statement
You are given a list of N people who are attending ACM-ICPC World Finals. Each of them are either well versed in a topic or they are not. Find out the maximum number of topics a 2-person team can know. And also find out how many teams can know that maximum number of topics.
ACM-ICPC World Finals�� �������� N ���� ������� ����� �����˴ϴ�. �׵� ������ ������ �ɼ��ϰų� �׷��� �ʽ��ϴ�. 2 �� ���� �� ���ִ� �ִ� ���� ���� Ȯ���Ͻʽÿ�. �׸��� �󸶳� ���� ���� �ִ� ���� ���� �� �� �ִ��� �˾ƺ��ʽÿ�.
Input Format
The first line contains two integers N and M separated by a single space, where N represents the number of people, and M represents the number of topics. N lines follow.
Each line contains a binary string of length M. If the ith line's jth character is 1, then the ithperson knows the jth topic and doesn't know the topic otherwise.

ù ��° �ٿ��� �� ���� ���� N�� M�� �ϳ��� �������� ���еǾ� �ֽ��ϴ�. N�� ��� ���� ��Ÿ���� M�� ���� ���� ��Ÿ���ϴ�. N ���� ���� �̾����ϴ�.
�� �ٿ��� ���� M�� ���� ���ڿ��� ��� �ֽ��ϴ�. i ��° ���� j ��° ���ڰ� 1�̸� i��° person�� j ��° �׸��� �˰� ������ �׷��� ������ �׸��� ���� ���մϴ�.

Output Format
On the first line, print the maximum number of topics a 2-person team can know.
On the second line, print the number of 2-person teams that can know the maximum number of topics. 
Constraints
2 �� N �� 500
1 �� M �� 500

Sample Input
4 5
10101
11100
11010
00101

Sample Output
5
2

Explanation
(1, 3) and (3, 4) know all the 5 topics. So the maximal topics a 2-person team knows is 5, and only 2 teams can achieve this.
 * 
 */

public class Solution_ICPCTeam {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int people = stdin.nextInt();
        int topics = stdin.nextInt();
        String know[] = new String[people];
        for(int i=0; i < people; i++)
            know[i] = stdin.next();

        int teamNumber = 0;
        int maxTopics = 0;
        for (int i = 0; i < people-1; i++) {
            for (int j = i+1; j < people; j++) {
                int topicCount = 0;
                for (int k = 0; k < topics; k++)
                    if (know[i].charAt(k) == '1' || know[j].charAt(k) == '1')
                        topicCount++;
                if (maxTopics < topicCount) {
                    maxTopics = topicCount;
                    teamNumber = 1;
                }
                else if (maxTopics == topicCount)
                    teamNumber++;
                //System.out.println(know[i] + " " + know[j] + " = " + topicCount);
            }
        }
        System.out.println(maxTopics);
        System.out.println(teamNumber);

        stdin.close();
    }
}
