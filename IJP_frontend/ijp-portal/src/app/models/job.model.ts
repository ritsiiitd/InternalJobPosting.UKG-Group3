export interface Job {
    jobPosId: number;
    description: string;
    minExp: number;
    minSal: number;
    maxSal: number;
    isActive: boolean;
    designation: string;
    createdBy: number;
    deadline: string;
    locations: number[];
    codingLanguages: number[];
  }