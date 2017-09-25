package hackerrank;

import java.util.Scanner;

/**
 * 
 * Problem Statement
You are given a list of N people who are attending ACM-ICPC World Finals. Each of them are either well versed in a topic or they are not. Find out the maximum number of topics a 2-person team can know. And also find out how many teams can know that maximum number of topics.
ACM-ICPC World Finals에 참가중인 N 명의 사람들의 목록이 제공됩니다. 그들 각각은 주제에 능숙하거나 그렇지 않습니다. 2 인 팀이 알 수있는 최대 주제 수를 확인하십시오. 그리고 얼마나 많은 팀이 최대 주제 수를 알 수 있는지 알아보십시오.
Input Format
The first line contains two integers N and M separated by a single space, where N represents the number of people, and M represents the number of topics. N lines follow.
Each line contains a binary string of length M. If the ith line's jth character is 1, then the ithperson knows the jth topic and doesn't know the topic otherwise.

첫 번째 줄에는 두 개의 정수 N과 M이 하나의 공백으로 구분되어 있습니다. N은 사람 수를 나타내고 M은 주제 수를 나타냅니다. N 개의 줄이 이어집니다.
각 줄에는 길이 M의 이진 문자열이 들어 있습니다. i 번째 줄의 j 번째 문자가 1이면 i번째 person은 j 번째 항목을 알고 있으며 그렇지 않으면 항목을 알지 못합니다.

Output Format
On the first line, print the maximum number of topics a 2-person team can know.
On the second line, print the number of 2-person teams that can know the maximum number of topics. 
Constraints
2 ≤ N ≤ 500
1 ≤ M ≤ 500

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
