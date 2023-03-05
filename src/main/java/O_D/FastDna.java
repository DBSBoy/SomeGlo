package O_D;

/**
 * 核酸最快检测效率
 * 在系统，网络均正常的情况下组织核酸采样员和志愿者对人群进行 核酸检测筛查。
 * 每名采样员的效率不同，采样效率为N人/小时，
 *
 * 由干外界变化，采样品的效率会以M人1小时为粒度发生变化，M为采样效率浮动粒度，M=N*10%，输入保证N*10%的结果为整数
 *
 * 采样员效率浮动规则:采样员需要一名志愿者协助组织才能发挥正常效率，在此基础上，每增加一名志愿者，效率提升1M，最多提升3M;如果没有志愿者协助组织，效率下降2M。
 * 怎么安排速度最快?求总最快检测效率(总检查效率为各采样人员效率值相加)。
 *
 * 输入描述
 *
 * 第一行:第一个值，采样品人数，取值范围[1, 100]:第一个值。志愿者人数:取值范围[1, 500]
 * 第二行:各采样员基准效率值(单位人/小时)，取值范围[60，600]，保证序列中每项值计算10%为整数。
 *
 * 输出描述
 * 总最快检测效率(单位人1小时)
 *
 * 示例1：
 * 输入：
 *
 * 2 2
 *
 * 200 200
 * 输出：
 *
 * 400
 * 说明：
 *
 * 输入保证采样员基准效率值序列的每个值*10%为整数。
 */
import java.util.*;
public class FastDna {
    static class Main {
        public static void main(String[] args) {
            // 输入处理
            Scanner in = new Scanner(System.in);
            int sample_num = in.nextInt();
            int volunteer_num = in.nextInt();

            Integer[] efficiencys = new Integer[sample_num];
            for (int i = 0; i < sample_num; i++) {
                efficiencys[i] = in.nextInt();
            }

            // 按效率排序，因为要先给效率最高的采样员配备志愿者
            Arrays.sort(efficiencys, (a, b) -> b - a);

            int result = 0;
            // 每个采样员配备的志愿者个数
            int count = 0;
            // 分别指向效率最高的采样员和效率最低的采样员(若志愿者<采样员，则为最后一个志愿者)，以便后续进行志愿者重新分配
            int i = 0;
            int j = 0;

            // 分支1: 志愿者<采样员，优先将志愿者分配给效率高的采样员
            if (volunteer_num < sample_num) {
                for (int k = 0; k < sample_num; k++) {
                    result += k < volunteer_num ? efficiencys[k] : efficiencys[k] * 0.8;
                }
                j = volunteer_num - 1;
                // 分支2: 志愿者>=采样员，先给每个采样员都分配一个志愿者
            } else {
                // 如果志愿者人数超过采样员四倍，则多出来的志愿者无效
                if (volunteer_num >= 4 * sample_num) {
                    volunteer_num = 4 * sample_num;
                }
                for (Integer val : efficiencys) {
                    result += val;
                }

                // 多出来的志愿者
                int remain_num = volunteer_num - sample_num;
                j = sample_num - 1;

                while (remain_num > 0) {
                    result += efficiencys[i] * 0.1;
                    remain_num--;
                    if (++count == 3) {
                        count = 0;
                        i++;
                    }
                }
            }

            // 剥夺低效率采样员的志愿者给高效率的采样员
            while (i < j) {
                // 最高效率的采样员上升10%的效率 > 最低效率的采样员下降20%的效率
                if (efficiencys[i] * 0.1 > efficiencys[j] * 0.2) {
                    result += efficiencys[i] * 0.1 - efficiencys[j] * 0.2;

                    // 最多就4个志愿者
                    if (++count == 3) {
                        count = 0;
                        i++;
                    }
                    j--;
                } else {
                    break;
                }
            }

            System.out.println(result);
        }

    }
}
